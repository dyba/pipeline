(ns pipeline.test.handler
  (:require [ring.mock.request :refer :all]
            [midje.sweet :refer :all]
            [pipeline.handler :refer :all]))

(fact "main route"
  (let [response (app (request :get "/"))]
    (:status response) => 200
    (.contains (:body response) => "Hello World")))

(fact "not-found route"
  (let [response (app (request :get "/invalid"))]
    (:status response) => 404))
