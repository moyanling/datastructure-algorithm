package org.mo39.fmbh

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.Json
import scalaj.http.{ Http, HttpOptions }
import org.mo39.fmbh.commons.utils.Z._

object Main extends App with LazyLogging {

  logger.info("Starting...")
  val workspaceId = "workspace_2faa27aac11b48c9aa07d9b4595bd144"
  val body = Http(
    s"http://appschema-server.appschema-server.next.test.internal.microstrategy.com:9000/workspaces/$workspaceId/queryplans")
    .method("POST")
    .header("Content-Type", "application/json")
    .header("Charset", "UTF-8")
    .option(HttpOptions.readTimeout(10000))
    .asString
    .body

  val json = Json.parse(body)
  (json \\ "sql")
    .map(_.as[String].replace("\t", " ").split("\n").last)
    .foreach(s => {
      val str =
        if (s.contains("where")) "The generated SQL should have the where clause \"" + s + "\""
        else "The generated SQL should not have the where clause"
      logger.info(str)
      str.toClipboard
    })
  logger.info("Done.")
}
