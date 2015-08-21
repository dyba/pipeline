(ns pipeline.migrations
  (:require [migratus.core :as migratus]))

(def config
  {:store :database
   :migration-dir "migrations"
   :db {:classname "org.postgresql.Driver"
        :subprotocel "postgresql"
        :subname "//localhost/pipeline_dev"
        :user "pipeline"}})
