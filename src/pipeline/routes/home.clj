(ns pipeline.routes.home
  (:require [compojure.core :refer [ANY defroutes]]
            [pipeline.views.layout :as layout]
            [cheshire.core :refer [encode decode]]
            [pipeline.db :refer [db-spec] :as db]
            [liberator.core :refer [defresource resource]]))

;; create a workflow

;; create a transition table based on ticket status
;; save the transition table to json or a Clojure data structure

;; create a ticket status on a workflow
;; define if a status is done
;; define if a status is the default value

;; what is a tracker?
;; records: start date, end date, parent task, category, assignee

;; trackers have workflows

;; roles have permissions

;; after ticket statuses have been defined, you can configure
;; transitions between ticket statuses allowed for a given role

(defresource item-statuses
  :handle-ok (fn [_]
               (let [statuses (vec (db/select-item-statuses db-spec))]
                 (encode {:pipeline
                          {:items statuses}})))
  :post! (fn [_]
           (let [item-status (db/create-item-status<! db-spec "new" false false)]
             (println item-status)))
  :allowed-methods [:get :post]
  :available-media-types ["application/vnd.pipeline+json"])

(defresource workflows
  :handle-ok (fn [_]
               (encode {:all :workflows}))
  :allowed-methods [:get]
  :available-media-types ["application/vnd.pipeline+json"])

(defresource root
  :handle-ok (fn [_]
               (encode {:links [{:rel "create-workflow" :href "http://localhost:3000/workflows"}]}))
  :allowed-methods [:get]
  :available-media-types ["application/vnd.pipeline+json"])

(defroutes home-routes
  (ANY "/" [] root)
  (ANY "/workflows" [] workflows)
  (ANY "/itemStatuses" [] item-statuses))
