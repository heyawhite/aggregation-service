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

load("@rules_java//java:defs.bzl", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

java_test(
    name = "AwsWorkerContinuousSmokeTest",
    timeout = "long",
    srcs = ["AwsWorkerContinuousSmokeTest.java"],
    tags = ["manual"],
    runtime_deps = [
        "//java/external:slf4j_simple",
    ],
    deps = [
        ":aws_worker_continuous_test_helper",
        "//java/com/google/aggregate/adtech/worker",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:avro_results_file_reader",
        "//java/com/google/aggregate/adtech/worker/util",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results_schema_supplier",
        "//java/com/google/aggregate/protocol/avro:avro_results_schema_supplier",
        "//java/com/google/aggregate/tools/diff:result_diff",
        "//java/external:acai",
        "//java/external:aws_regions",
        "//java/external:aws_s3",
        "//java/external:aws_url_connection_client",
        "//java/external:clients_blobstorageclient_aws",
        "//java/external:clients_blobstorageclient_model",
        "//java/external:frontend_java_proto",
        "//java/external:google_truth",
        "//java/external:guice",
        "//java/external:jackson_databind",
        "//java/external:jackson_datatype_jsr310",
    ],
)

java_test(
    name = "AwsWorkerContinuousSmokeTestChromeReports",
    timeout = "long",
    srcs = ["AwsWorkerContinuousSmokeTestChromeReports.java"],
    tags = ["manual"],
    runtime_deps = [
        "//java/external:slf4j_simple",
    ],
    deps = [
        ":aws_worker_continuous_test_helper",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:avro_results_file_reader",
        "//java/com/google/aggregate/adtech/worker/util",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results_schema_supplier",
        "//java/com/google/aggregate/protocol/avro:avro_results_schema_supplier",
        "//java/com/google/aggregate/tools/diff:result_diff",
        "//java/external:acai",
        "//java/external:aws_regions",
        "//java/external:aws_s3",
        "//java/external:aws_url_connection_client",
        "//java/external:clients_blobstorageclient_aws",
        "//java/external:clients_blobstorageclient_model",
        "//java/external:frontend_java_proto",
        "//java/external:google_truth",
        "//java/external:guice",
        "//java/external:jackson_databind",
        "//java/external:jackson_datatype_jsr310",
    ],
)

java_test(
    name = "AwsWorkerContinuousDiffTest",
    timeout = "eternal",
    srcs = ["AwsWorkerContinuousDiffTest.java"],
    tags = ["manual"],
    runtime_deps = [
        "//java/external:slf4j_simple",
    ],
    deps = [
        ":aws_worker_continuous_test_helper",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:avro_results_file_reader",
        "//java/com/google/aggregate/tools/diff:result_diff",
        "//java/external:acai",
        "//java/external:aws_regions",
        "//java/external:aws_s3",
        "//java/external:aws_url_connection_client",
        "//java/external:clients_blobstorageclient_aws",
        "//java/external:clients_blobstorageclient_model",
        "//java/external:frontend_java_proto",
        "//java/external:google_truth",
        "//java/external:guice",
        "//java/external:jackson_databind",
        "//java/external:jackson_datatype_jsr310",
    ],
)

java_test(
    name = "AwsWorkerContinuousPerfTest",
    timeout = "eternal",
    srcs = ["AwsWorkerContinuousPerfTest.java"],
    tags = ["manual"],
    runtime_deps = [
        "//java/external:slf4j_simple",
    ],
    deps = [
        ":aws_worker_continuous_test_helper",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:avro_results_file_reader",
        "//java/com/google/aggregate/tools/diff:result_diff",
        "//java/external:acai",
        "//java/external:aws_regions",
        "//java/external:aws_s3",
        "//java/external:aws_url_connection_client",
        "//java/external:clients_blobstorageclient_aws",
        "//java/external:clients_blobstorageclient_model",
        "//java/external:frontend_java_proto",
        "//java/external:google_truth",
        "//java/external:guice",
        "//java/external:jackson_databind",
        "//java/external:jackson_datatype_jsr310",
    ],
)

java_test(
    name = "AwsWorkerContinuousInvalidCredentialsTest",
    timeout = "eternal",
    srcs = ["AwsWorkerContinuousInvalidCredentialsTest.java"],
    tags = ["manual"],
    runtime_deps = [
        "//java/external:slf4j_simple",
    ],
    deps = [
        ":aws_worker_continuous_test_helper",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:avro_results_file_reader",
        "//java/com/google/aggregate/tools/diff:result_diff",
        "//java/external:acai",
        "//java/external:aws_regions",
        "//java/external:aws_s3",
        "//java/external:aws_url_connection_client",
        "//java/external:clients_blobstorageclient_aws",
        "//java/external:clients_blobstorageclient_model",
        "//java/external:frontend_java_proto",
        "//java/external:google_truth",
        "//java/external:guice",
        "//java/external:jackson_databind",
        "//java/external:jackson_datatype_jsr310",
    ],
)

java_library(
    name = "aws_worker_continuous_test_helper",
    srcs = ["AwsWorkerContinuousTestHelper.java"],
    deps = [
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:avro_results_file_reader",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results_schema_supplier",
        "//java/com/google/aggregate/protocol/avro:avro_results_schema_supplier",
        "//java/com/google/aggregate/tools/diff:result_diff",
        "//java/external:apache_httpclient",
        "//java/external:apache_httpcore",
        "//java/external:aws_apache_http",
        "//java/external:aws_auth",
        "//java/external:aws_http_client_spi",
        "//java/external:aws_regions",
        "//java/external:aws_s3",
        "//java/external:aws_url_connection_client",
        "//java/external:aws_utils",
        "//java/external:clients_blobstorageclient_aws",
        "//java/external:clients_blobstorageclient_model",
        "//java/external:frontend_java_proto",
        "//java/external:google_truth",
        "//java/external:guava",
        "//java/external:guice",
        "//java/external:jackson_databind",
        "//java/external:jackson_datatype_jdk8",
        "//java/external:jackson_datatype_jsr310",
        "//java/external:protobuf_java_util",
    ],
)

java_test(
    name = "AggregationWorkerTest",
    srcs = ["AggregationWorkerTest.java"],
    deps = [
        "//java/com/google/aggregate/adtech/worker",
        "//java/com/google/aggregate/adtech/worker/configs",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:fake_job_result_generator",
        "//java/com/google/aggregate/adtech/worker/testing:noop_job_processor",
        "//java/com/google/aggregate/perf",
        "//java/com/google/aggregate/perf/export:no_op_exporter",
        "//java/com/google/aggregate/privacy/noise/proto:privacy_parameters_java_proto",
        "//java/external:clients_jobclient_aws",
        "//java/external:clients_jobclient_model",
        "//java/external:clients_metricclient_aws",
        "//java/external:google_truth",
        "//java/external:google_truth8",
        "//java/external:guice",
    ],
)

java_test(
    name = "ReportDecrypterAndValidatorTest",
    srcs = ["ReportDecrypterAndValidatorTest.java"],
    deps = [
        "//java/com/google/aggregate/adtech/worker",
        "//java/com/google/aggregate/adtech/worker/decryption",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:fake_record_decrypter",
        "//java/com/google/aggregate/adtech/worker/testing:fake_report_generator",
        "//java/com/google/aggregate/adtech/worker/testing:fake_validator",
        "//java/com/google/aggregate/adtech/worker/validation",
        "//java/external:acai",
        "//java/external:clients_jobclient_aws",
        "//java/external:clients_jobclient_model",
        "//java/external:google_truth",
        "//java/external:google_truth8",
        "//java/external:guice",
        "//java/external:operator_protos",
        "//java/external:shared_model",
    ],
)

java_test(
    name = "ErrorSummaryAggregatorTest",
    srcs = ["ErrorSummaryAggregatorTest.java"],
    deps = [
        "//java/com/google/aggregate/adtech/worker",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:fake_report_generator",
        "//java/external:google_truth",
        "//java/external:guava",
        "//java/external:operator_protos",
        "//java/external:shared_model",
    ],
)

java_test(
    name = "LocalFileToCloudStorageLoggerTest",
    srcs = ["LocalFileToCloudStorageLoggerTest.java"],
    deps = [
        "//java/com/google/aggregate/adtech/worker",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:avro_results_file_reader",
        "//java/com/google/aggregate/adtech/worker/util",
        "//java/com/google/aggregate/adtech/worker/writer",
        "//java/com/google/aggregate/adtech/worker/writer/avro",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results",
        "//java/com/google/aggregate/protocol/avro:avro_debug_results_schema_supplier",
        "//java/com/google/aggregate/protocol/avro:avro_results_schema_supplier",
        "//java/external:acai",
        "//java/external:clients_blobstorageclient_aws",
        "//java/external:clients_blobstorageclient_model",
        "//java/external:clients_jobclient_aws",
        "//java/external:clients_jobclient_model",
        "//java/external:google_truth",
        "//java/external:guice",
        "//java/external:javax_inject",
        "//java/external:jimfs",
    ],
)

java_test(
    name = "AwsWorkerAutoScalingTest",
    timeout = "eternal",  # 60 minute timeout timeout
    srcs = ["AwsWorkerAutoScalingTest.java"],
    tags = ["manual"],
    runtime_deps = [
        "//java/external:slf4j_simple",
    ],
    deps = [
        ":aws_worker_continuous_test_helper",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/external:acai",
        "//java/external:aws_auto_scaling",
        "//java/external:aws_regions",
        "//java/external:aws_s3",
        "//java/external:aws_url_connection_client",
        "//java/external:frontend_java_proto",
        "//java/external:google_truth",
        "//java/external:guice",
    ],
)

java_test(
    name = "LocalRunnerTest",
    srcs = ["LocalRunnerTest.java"],
    data = [
        "//worker/testing/data/library:test_data",
    ],
    deps = [
        "//java/com/google/aggregate/adtech/worker",
        "//java/com/google/aggregate/adtech/worker:worker_runner",
        "//java/com/google/aggregate/adtech/worker/configs",
        "//java/com/google/aggregate/adtech/worker/model",
        "//java/com/google/aggregate/adtech/worker/testing:fake_job_result_generator",
        "//java/com/google/aggregate/adtech/worker/testing:noop_job_processor",
        "//java/com/google/aggregate/adtech/worker/util",
        "//java/com/google/aggregate/perf",
        "//java/com/google/aggregate/perf/export:no_op_exporter",
        "//java/com/google/aggregate/privacy/noise/proto:privacy_parameters_java_proto",
        "//java/external:clients_jobclient_aws",
        "//java/external:clients_jobclient_model",
        "//java/external:clients_metricclient_aws",
        "//java/external:google_truth",
        "//java/external:google_truth8",
        "//java/external:guava",
        "//java/external:guice",
        "//java/external:jackson_core",
        "//java/external:jackson_databind",
        "//java/external:jcommander",
        "//java/external:jimfs",
    ],
)
