(ns dev
  (:require
   [integrant.repl :as igr]
   [picture-gallery.core :as pg-core]))

(defn start
  ([] (start pg-core/config-file))
  ([config-file]
   (igr/set-prep! (constantly (pg-core/load-config config-file)))
   (igr/prep)
   (igr/init)))

(defn stop []
  (igr/halt))

(defn restart []
  (igr/reset-all))

