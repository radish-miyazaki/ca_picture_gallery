(ns picture-gallery.domain.ping-test
  (:require
   [clojure.spec.alpha :as s]
   [clojure.test :refer [deftest is]]
   [picture-gallery.domain.ping :as domain]
   [picture-gallery.utils.string :as pg-string]))

(deftest ping
  (is (not (s/valid? ::domain/ping "pong")))
  (is (not (s/valid? ::domain/ping 0)))
  (is (s/valid? ::domain/ping "ping")))

(deftest pong
  (is (not (s/valid? ::domain/pong "ping")))
  (is (not (s/valid? ::domain/pong 0)))
  (is (s/valid? ::domain/pong "pong")))

(deftest _comment
  (is (s/valid? ::domain/comment nil))
  (is (s/valid? ::domain/comment "hello"))
  (is (not (s/valid? ::domain/comment (pg-string/rand-str 2048)))))

