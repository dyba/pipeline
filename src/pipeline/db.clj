(ns pipeline.db
  (:require [environ.core :refer [env]]
            [yesql.core :refer [defquery]]))

(def db-spec {:user (get env :database-user "pipeline")
              :password (get env :database-password "pipeline")
              :subprotocol "postgresql"
              :subname (str "//" (get env :database-host "localhost") "/" (get env :database-name))
              :port (get env :database-port "5432")})

(defquery select-item-statuses "queries/queries.sql")
