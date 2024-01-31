(ns picture-gallery.domain.ping
  (:require
   [clojure.spec.alpha :as s]))

(def max-comment-length 1024)

(s/def ::ping (s/and string? (partial = "ping")))
(s/def ::pong (s/and string? (partial = "pong")))
(s/def ::comment (s/nilable (s/and string? #(< (count %) max-comment-length))))

(s/def ::ping-input
  (s/keys :req-un [::ping] :opt-un [::comment]))
(s/def ::ping-output
  (s/keys :req-un [::pong] :opt-un [::comment]))

