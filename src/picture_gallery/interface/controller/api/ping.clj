(ns picture-gallery.interface.controller.api.ping
  (:require
   [clojure.spec.alpha :as s]
   [picture-gallery.domain.error :as domain-error]
   [picture-gallery.domain.openapi.ping :as openapi]
   [picture-gallery.domain.ping :as domain]))

(s/def ::query ::openapi/ping-request)
(s/def ::parameters (s/keys :req-un [::query]))
(s/def ::http-input-data (s/keys :req-un [::parameters]))

(s/fdef http->
  :args (s/cat :input-data ::http-input-data)
  :ret (s/or :success (s/tuple ::domain/ping-input nil?)
             :failure (s/tuple nil? ::domain-error/error)))

(defn http->
  "http request -> usecase input model"
  [input-data]
  (let [{:keys [parameters]} input-data
        {:keys [query]} parameters
        {:keys [_ comment]} query
        input-model (cond-> {:ping (:ping query)}
                       comment (assoc :comment comment))
        conformed-input-model (s/conform ::domain/ping-input input-model)]
    (if (not= ::s/invalid conformed-input-model)
      [conformed-input-model nil]
      [nil (domain-error/input-data-is-invalid (s/explain-str ::domain/ping-input input-model))])))

