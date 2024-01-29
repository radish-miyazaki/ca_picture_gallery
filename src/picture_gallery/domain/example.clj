(ns picture-gallery.domain.example
  (:require
   [clojure.spec.alpha :as s]))

(def max-comment-length 1024)

(s/def ::ping (s/and string? (partial = "ping")))
(s/def ::pong (s/and string? (partial = "pong")))

(s/def ::not-exist-comment nil?)
(s/def ::exist-comment (s/and string? #(< (count %) max-comment-length)))
(s/def ::comment (s/or :not-exist-comment ::not-exist-comment
                      :exist-comment ::exist-comment))

