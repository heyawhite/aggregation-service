# Copyright 2022 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

load("@rules_java//java:defs.bzl", "java_test")

java_test(
    name = "AvroShardTest",
    srcs = ["AvroShardTest.java"],
    data = [
        "//worker/testing/data/library:test_data",
    ],
    deps = [
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/writer/avro",
        "//java/com/google/aggregate/protocol/avro:avro_output_domain",
        "//java/com/google/aggregate/protocol/avro:avro_record_reader",
        "//java/com/google/aggregate/protocol/avro:avro_report",
        "//java/com/google/aggregate/tools/shard:avro_shard",
        "//java/external:acai",
        "//java/external:google_truth",
        "//java/external:guice",
        "//java/external:javax_inject",
    ],
)
