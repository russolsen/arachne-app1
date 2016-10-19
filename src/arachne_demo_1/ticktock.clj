(ns arachne-demo-1.ticktock
  (:require [com.stuartsierra.component :as c]
            [clojure.tools.logging :as log]))

(defn- ticktock
  [state]
  (when-let [s @state]
    (log/info s)
    (swap! state #(case %, "tick" "tock", "tock" "tick", nil))
    (future
      (Thread/sleep 1000)
      (ticktock state))))

(defrecord TickTock [state]
  c/Lifecycle
  (start [this]
    (log/info "starting ticktock")
    (let [state (atom "tick")]
      (ticktock state)
      (assoc this :state state)))
  (stop [this]
    (reset! state nil)
    this))

