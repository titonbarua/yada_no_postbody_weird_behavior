(ns main
  (:require [yada.yada :as yada]
            [schema.core :as sc]))

(def params-hello
  {:form {:name sc/Str}})

(def hello-resource
  (yada/resource
   {:methods
    {:post
     {:parameters params-hello
      :produces   "text/html"
      :consumes   "application/x-www-form-urlencoded"
      :response   (fn [ctx]
                    (format "<h1>Hello, %s !</h1>"
                            (get-in ctx [:parameters :form :name])))}}}))

(defn -main [& args]
  (yada/listener ["/" hello-resource] {:port 8080})
  (Thread/sleep 10000000))
