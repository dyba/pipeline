(defproject pipeline "0.1.0-SNAPSHOT"
  :description "A Workflow API"
  :url "https://github.com/dyba/pipeline"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [cheshire "5.5.0"]
                 [ring-server "0.3.1"]
                 [migratus "0.8.4"]
                 [liberator "0.13"]
                 [environ "1.0.0"]
                 [yesql "0.4.2"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]]
  :plugins [[lein-ring "0.8.12"]
            [migratus-lein "0.1.5"]
            [lein-environ "1.0.0"]]
  :ring {:handler pipeline.handler/app
         :init pipeline.handler/init
         :destroy pipeline.handler/destroy}
  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "org.postgresql.Driver"
                  :subprotocol "postgresql"
                  :subname "//localhost:5432/pipeline_dev"
                  :user "pipeline"
                  :password ""}}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.2.0"]
                   [ring/ring-devel "1.3.1"]
                   [midje "1.7.0"]]}})
