(ns picture-gallery.interface.presenter.api.ping
  (:require
   [clojure.spec.alpha :as s]
   [picture-gallery.domain.error :as domain-error]
   [picture-gallery.domain.openapi.base :as openapi-base]
   [picture-gallery.domain.openapi.ping :as openapi]
   [picture-gallery.domain.ping :as domain]))

(s/def ::body ::openapi/ping-response)
(s/def ::http-output-data (s/keys :req-un [::openapi-base/status ::body]))

(s/fdef ->http
  :args (s/cat :arg
               (s/or :success (s/tuple ::domain/ping-output nil?)
                     :failure (s/tuple nil? ::domain-error/error)))
  :ret (s/or :success ::http-output-data
             :failure ::domain-error/error))

(defn ->http
  "usecase output model -> http response"
  [[output-data error]]
  (if (nil? error)
    {:status 200
     :body output-data}
    error))

