(ns picture-gallery.infrastructure.logger
  (:require
   [integrant.core :as ig]
   [taoensso.timbre :as timbre]))

(defmethod ig/init-key ::logger [_ {:keys [env]}]
  (println "set logger with log-level" (:log-level env))
  (timbre/set-min-level! (:log-level env))
  {})

