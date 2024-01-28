(ns picture-gallery.infrastructure.router.core
  (:require
   [integrant.core :as ig]
   [muuntaja.core :as m]
   [reitit.coercion.spec]
   [reitit.dev.pretty :as pretty]
   [reitit.ring :as ring]
   [reitit.ring.coercion :as coercion]
   [reitit.ring.middleware.exception :as exception]
   [reitit.ring.middleware.multipart :as multipart]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [reitit.ring.middleware.parameters :as parameters]
   [reitit.swagger :as swagger]
   [reitit.swagger-ui :as swagger-ui]
   [taoensso.timbre :as timbre]))

(defn app [_]
  (ring/ring-handler
   (ring/router
    [["/swagger.json" {:get {:no-doc true
                             :swagger {:info {:title "picture-gallery-api"
                                              :securityDefinitions
                                              {:Bearer
                                               {:type "apiKey"
                                                :in "header"
                                                :name "Authorization"}}
                                              :basePath "/"}}
                             :handler (swagger/create-swagger-handler)}}]
     ;; TODO: "/api" 以下に機能を定義していく
     ["/api"]]
    {:exception pretty/exception
     :data {:coercion reitit.coercion.spec/coercion
            :muuntaja m/instance
            :middleware [swagger/swagger-feature
                         parameters/parameters-middleware
                         exception/exception-middleware
                         muuntaja/format-negotiate-middleware
                         muuntaja/format-response-middleware
                         muuntaja/format-request-middleware
                         coercion/coerce-response-middleware
                         coercion/coerce-request-middleware
                         multipart/multipart-middleware]}})
   (swagger-ui/create-swagger-ui-handler {:path "/api"})
   (ring/create-default-handler)))

(defmethod ig/init-key ::router
  [_ {:keys [env]}]
  (timbre/info "router got: env" env)
  (app env))

