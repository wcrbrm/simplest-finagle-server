import $ivy.`com.twitter::finagle-http:18.11.0`, com.twitter.finagle._, com.twitter.util._
val service = new Service[http.Request, http.Response] {
  def apply(req: http.Request): Future[http.Response] = {
    val response = http.Response(req.version, http.Status.Ok)
    response.contentString = "Hello!"
    Future.value(response)
  }
}
val server = Http.serve(":8222", service)
Await.ready(server)
