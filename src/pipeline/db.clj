(ns pipeline.db
  (:require [korma.db :refer [defdb postgres]]
            [korma.core
             :refer [defentity entity-fields select]]
            [environ.core :refer [env]]))

(defdb db (postgres {:db (env :database-name)
                     :user (get (env :database-user) "")
                     :host (get env :database-host "localhost")
                     :port (get env :database-port "5432")
                     :password (get (env :database-password) "")}))

(defentity ticket-issues
  (entity-fields :name :issue-closed :default-value))


