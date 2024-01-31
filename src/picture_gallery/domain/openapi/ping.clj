(ns picture-gallery.domain.openapi.ping
  (:require
   [clojure.spec.alpha :as s]))

(s/def ::ping string?)
(s/def ::comment string?)
(s/def ::pong string?)

(s/def ::ping-request (s/keys :req-un [::ping] :opt-un [::comment]))
(s/def ::ping-response (s/keys :req-un [::pong] :opt-un [::comment]))

