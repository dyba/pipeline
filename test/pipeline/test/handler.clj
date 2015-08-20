(ns pipeline.test.handler
  (:use midje.sweet
        ring.mock.request
        pipeline.handler))

(fact "main route"
  (let [response (app (request :get "/"))]
    (:status response) => 200
    (.contains (:body response) => "Hello World")))

(fact "not-found route"
  (let [response (app (request :get "/invalid"))]
    (:status response) => 404))
