(require '[arachne.core.dsl :as core])
(require '[arachne.http.dsl :as http])
(require '[arachne.pedestal.dsl :as ped])

(core/runtime :arachne-demo-1/runtime [:arachne-demo-1/server])
(core/runtime :arachne-demo-1/runtime2 [:arachne-demo-1/ticktock])

(core/component :arachne-demo-1/ticktock {}
  'arachne-demo-1.ticktock/->TickTock)

(ped/server :arachne-demo-1/server 8080

  (http/endpoint :get "/status"
    (http/handler :arachne-demo-1/status
      {:arachne-demo-1/ticktock :data-source}
      'arachne-demo-1.web/status)
    :arachne-demo-1/status)

  )