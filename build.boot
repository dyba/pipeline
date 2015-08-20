(ns pipeline.boot
  {:boot/export-tasks true}
  (:require [clojure.java.io :as io]
            [boot.core :refer [set-env! deftask]]))

(set-env! :db-path "data/postgres")

(deftask mkdirp
  "Recursively creates directories."
  [d directories PATH str "The directory path to create"]
  (io/make-parents (str directories "/nothing")))

(deftask setup-db
  "Setup the postgres database."
  
  )
