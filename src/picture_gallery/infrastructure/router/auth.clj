(ns picture-gallery.infrastructure.router.auth
  (:require
   [clojure.walk :as w]
   [picture-gallery.domain.openapi.auth :as openapi]))

(defn signin-post-handler [input-data]
  (println (-> input-data :headers w/keywordize-keys :authorization))
  {:status 200
   :body {:user-id "123123123123123"}})

(defn signup-post-handler [_]
  {:status 201
   :body {:user-id "123123123123123"}})

(defn auth-router []
  ["/auth"
   ["/signin"
    {:swagger {:tags ["auth"]}
     :post {:summary "signin with firebase-auth token"
            :swagger {:security [{:Bearer []}]}
            :response {201 {:body ::openapi/signin-response}}
            :handler signin-post-handler}}]
   ["/signup"
    {:swagger {:tags ["auth"]}
     :post {:summary "signup with firebase-auth token"
            :swagger {:security [{:Bearer []}]}
            :response {201 {:body ::openapi/signup-response}}
            :handler signup-post-handler}}]])

