(ns picture-gallery.domain.users 
  (:require
   [clojure.spec.alpha :as s]))

(defn- user-id? [num-str]
  (re-matches #"^[0-9]{15}" num-str))

(defn gen-user-id []
  (apply str (take 15 (repeatedly #(rand-int 10)))))

(s/def ::user-id (s/and string? user-id?))
(s/def ::id-token string?)
(s/def ::created-at pos-int?)

(s/def ::user-create-model
  (s/keys :req-un [::user-id ::id-token]))

(s/def ::user-model
  (s/keys :req-un [::user-id ::id-token ::created-at]))

(s/def ::users-model
  (s/coll-of ::user-model))

