(ns picture-gallery.core
  (:gen-class)
  (:require
   [clojure.java.io :as io]
   [environ.core :refer [env]]
   [integrant.core :as ig]))

(def config-file
  (if-let [config-file (env :config-file)]
    config-file
    "config.edn"))

(defn load-config [config]
  (-> config
      io/resource
      slurp
      ig/read-string
      (doto
          ig/load-namespaces)))

(defn -main
  [& _]
  (-> config-file
      load-config
      ig/init))

