package org.mo39.fmbh

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.Json
import scalaj.http.{ Http, HttpOptions }
import org.mo39.fmbh.commons.utils.Z._

object Main extends App with LazyLogging {

  logger.info("Starting...")
  val workspaceId = "workspace_19f0e594c1cc46b2b82ffdd817fba1f2"
  val body = Http(
    s"http://10.15.69.120:9000/workspaces/$workspaceId/queryplans")
    .method("POST")
    .header("Content-Type", "application/json")
    .header("Charset", "UTF-8")
    .option(HttpOptions.readTimeout(10000))
    .asString
    .body

  val json = Json.parse(body)

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
