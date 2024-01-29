(ns picture-gallery.domain.example-test
  (:require
   [clojure.spec.alpha :as s]
   [clojure.test :refer [deftest is]]
   [picture-gallery.domain.example :as sut]
   [picture-gallery.utils.string :as pg-string]))

(deftest ping
  (is (not (s/valid? ::sut/ping "pong")))
  (is (not (s/valid? ::sut/ping 0)))
  (is (s/valid? ::sut/ping "ping")))

(deftest pong
  (is (not (s/valid? ::sut/pong "ping")))
  (is (not (s/valid? ::sut/pong 0)))
  (is (s/valid? ::sut/pong "pong")))

(deftest _comment
  (is (s/valid? ::sut/comment nil))
  (is (s/valid? ::sut/comment "hello"))
  (is (not (s/valid? ::sut/comment (pg-string/rand-str 2048)))))

