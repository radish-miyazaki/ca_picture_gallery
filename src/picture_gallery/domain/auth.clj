(ns picture-gallery.domain.auth
  (:require
   [clojure.spec.alpha :as s]
   [picture-gallery.domain.base :as base]
   [picture-gallery.domain.error :as error]
   [picture-gallery.domain.users :as users]))

(s/def ::encrypted-id-token string?)

(s/def ::signin-input
  (s/keys :req-un [::encrypted-id-token]))

(s/def ::signin-output
  (s/keys :req-un [::users/user-id]))

(s/def ::signup-input
  (s/keys :req-un [::encrypted-id-token]))

(s/def ::signup-output
  (s/keys :req-un [::users/user-id]))

(s/def ::decode-id-token-success
  (s/tuple ::base/succes (s/keys :req-un [::users/id-token])))

(s/def ::decode-id-token-failure
  (s/tuple ::base/failure ::error/error))

(s/def ::decode-id-token-result
  (s/or :success ::decode-id-token-success
        :failure ::decode-id-token-failure))

