(require '[arachne.core.dsl :as core])
(require '[arachne.http.dsl :as http])
(require '[arachne.pedestal.dsl :as ped])

(core/runtime :arachne-demo-1/runtime [:arachne-demo-1/server])

(http/handler :arachne-demo-1/hello-world {}
  'arachne-demo-1.web/hello-world)

(ped/server :arachne-demo-1/server 8080

  (http/endpoint :get "/hello/:name" :arachne-demo-1/hello-world)

  (ped/interceptor "/hello"
    (core/component :arachne-demo-1/insulter {}
      'arachne-demo-1.web/insulter))


  )
