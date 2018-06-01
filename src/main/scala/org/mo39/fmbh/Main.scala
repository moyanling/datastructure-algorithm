package org.mo39.fmbh

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.Json
import scalaj.http.{ Http, HttpOptions }
import org.mo39.fmbh.commons.utils.Z._

object Main extends App with LazyLogging {

  logger.info("Starting...")
  val workspaceId = "workspace_3e698c4a3dcf4797bbd136231a5ea6df"
  val body = Http(
    s"http://appschema-server.appschema-server.next.test.internal.microstrategy.com:9000/workspaces/$workspaceId/queryplans")
    .method("POST")
    .header("Content-Type", "application/json")
    .header("Charset", "UTF-8")
    .option(HttpOptions.readTimeout(10000))
    .asString
    .body

  val json = Json.parse(body)
  println(json)
  (json \\ "sql")
    .map(_.as[String].replace("\t", " ").split("\\n(?=where)").last)
    .map(s => {
      val str = //s"where  $s"
        if (s.contains("where")) "The generated SQL should have the where clause\n\"" + s + "\""
        else "The generated SQL should not have the where clause"
      logger.info(str)
      str
    }).mkString("\n").toClipboard
  logger.info("Done.")
}
