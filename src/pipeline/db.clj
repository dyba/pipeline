(ns pipeline.db
  (:require [korma.db :refer [defdb postgres]]
            [korma.core
             :refer [defentity entity-fields select]]
            [environ.core :refer [env]]))

(defdb db (postgres {:db (env :db)
                     :user (env :username)
                     :password (env :password)}))

(defentity ticket-issues
  (entity-fields :name :issue-closed :default-value))


