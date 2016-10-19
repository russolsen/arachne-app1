(ns arachne-demo-1
  (:require [arachne.core :as arachne]
            [com.stuartsierra.component :as component]))

(def c (atom nil))

;; In a main function
(defn -main
  "Application entry point"
  [config-file & _]
  (let [cfg (arachne/build-config
              [:org.arachne-framework/arachne-pedestal
               :org.arachne-framework/arachne-assets]
              config-file)
        rt (arachne/runtime cfg :arachne-demo-1/runtime)]
    (reset! c rt)
    (component/start rt)))



;; From the REPL
(comment

  (def cfg (arachne/build-config
             [:org.arachne-framework/arachne-pedestal]
             "config/web.clj"))

  (def rt (atom
            (arachne/runtime cfg :arachne-demo-1/runtime)))

  (swap! rt component/start)
  (swap! rt component/stop)

  )


(comment
  ;; explore the config...

  (require '[datomic.api :as d])

  (d/q '[:find ?i ?c
         :in $
         :where
         [?i :arachne.pedestal.interceptor/route ?r]
         [?i :arachne.component/constructor ?c]]
      (:db cfg))

  (use 'clojure.pprint)

  (pprint
    (d/pull (:db cfg) '[*] 17592186045462))

  )
