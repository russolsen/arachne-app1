(ns arachne-demo-1.web
  (:require [clojure.string :as str]
            [arachne.http :as http]))

(defn hello-world
  "Hello-world handler function"
  [req]
  {:status 200
   :body (str "Hello, " (-> req :path-params :name))})

(defn insulter
  "Constructor for a insulting interceptor"
  []
  {:leave (fn [ctx]
            (update-in ctx [:response :body] str/replace "Luke"
              "optimistic webapp-building fool"))})

(defn status
  "Status handler function"
  [req]
  (let [data-source (:data-source req)]
    {:status 200
     :body (str "Current state: " @(:state data-source))}))