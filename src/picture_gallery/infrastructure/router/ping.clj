(ns picture-gallery.infrastructure.router.ping
  (:require
   [picture-gallery.domain.openapi.ping :as openapi]
   [picture-gallery.interface.controller.api.ping :as controller]
   [picture-gallery.interface.presenter.api.ping :as presenter]
   [picture-gallery.usecase.ping :as usecase]
   [picture-gallery.utils.error :refer [err->>]]))

(defn ping-handler [input-data]
  (presenter/->http
   (err->> input-data
           controller/http->
           usecase/ping)))

(defn ping-router []
  ["/ping"
   {:swagger {:tags ["ping"]}
    :post {:summary "ping - pong"
           :parameters {:query ::openapi/ping-request}
           :responses {200 {:body ::openapi/ping-response}}
           :handler ping-handler}}])

