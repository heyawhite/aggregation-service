load("@bazel_tools//tools/build_defs/repo:git.bzl", "git_repository")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive", "http_file")

##############
# Java rules #
##############

RULES_JVM_EXTERNAL_TAG = "4.0"

RULES_JVM_EXTERNAL_SHA = "31701ad93dbfe544d597dbe62c9a1fdd76d81d8a9150c2bf1ecf928ecdf97169"

http_archive(
    name = "rules_jvm_external",
    sha256 = RULES_JVM_EXTERNAL_SHA,
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

# Declare explicit protobuf version, to override any implicit dependencies.
PROTOBUF_CORE_VERSION = "3.19.4"

COORDINATOR_VERSION = "v0.51.5"  # version updated on 2023-02-22

JACKSON_VERSION = "2.12.2"

AUTO_VALUE_VERSION = "1.7.4"

AWS_SDK_VERSION = "2.17.239"

GOOGLE_GAX_VERSION = "2.4.0"

TINK_VERSION = "1.5.0"

AUTO_SERVICE_VERSION = "1.0"

load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

rules_jvm_external_deps()

load("@rules_jvm_external//:setup.bzl", "rules_jvm_external_setup")

rules_jvm_external_setup()

load("@rules_jvm_external//:defs.bzl", "maven_install")

http_archive(
    name = "com_google_protobuf",
    sha256 = "3bd7828aa5af4b13b99c191e8b1e884ebfa9ad371b0ce264605d347f135d2568",
    strip_prefix = "protobuf-%s" % PROTOBUF_CORE_VERSION,
    urls = [
        "https://github.com/protocolbuffers/protobuf/archive/v%s.tar.gz" % PROTOBUF_CORE_VERSION,
    ],
)

# Use following instead of git_repository for local development
#local_repository(
#    name = "com_google_adm_cloud_scp",
#    path = "<LOCAL PATH TO SCP REPO>",
#)

git_repository(
    name = "com_google_adm_cloud_scp",
    remote = "https://github.com/privacysandbox/control-plane-shared-libraries",
    tag = COORDINATOR_VERSION,
)

load("@com_google_adm_cloud_scp//build_defs/tink:tink_defs.bzl", "TINK_MAVEN_ARTIFACTS", "import_tink_git")

import_tink_git(repo_name = "@com_google_adm_cloud_scp")

maven_install(
    artifacts = [
        "com.amazonaws:aws-lambda-java-core:1.2.1",
        "com.amazonaws:aws-lambda-java-events:3.8.0",
        "com.amazonaws:aws-lambda-java-events-sdk-transformer:3.0.4",
        "com.amazonaws:aws-java-sdk-sqs:1.11.860",
        "com.amazonaws:aws-java-sdk-s3:1.11.860",
        "com.amazonaws:aws-java-sdk-kms:1.11.860",
        "com.amazonaws:aws-java-sdk-core:1.11.860",
        "com.beust:jcommander:1.81",
        "com.fasterxml.jackson.core:jackson-annotations:" + JACKSON_VERSION,
        "com.fasterxml.jackson.core:jackson-core:" + JACKSON_VERSION,
        "com.fasterxml.jackson.core:jackson-databind:" + JACKSON_VERSION,
        "com.fasterxml.jackson.datatype:jackson-datatype-guava:" + JACKSON_VERSION,
        "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:" + JACKSON_VERSION,
        "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:" + JACKSON_VERSION,
        "com.fasterxml.jackson.dataformat:jackson-dataformat-cbor:" + JACKSON_VERSION,
        "com.google.acai:acai:1.1",
        "com.google.auto.factory:auto-factory:1.0",
        "com.google.auto.service:auto-service-annotations:" + AUTO_SERVICE_VERSION,
        "com.google.auto.service:auto-service:" + AUTO_SERVICE_VERSION,
        "com.google.auto.value:auto-value-annotations:" + AUTO_VALUE_VERSION,
        "com.google.auto.value:auto-value:" + AUTO_VALUE_VERSION,
        "com.google.code.findbugs:jsr305:3.0.2",
        "com.google.cloud:google-cloud-kms:2.1.2",
        "com.google.cloud:google-cloud-secretmanager:2.2.0",
        "com.google.cloud:google-cloud-pubsub:1.114.4",
        "com.google.cloud:google-cloud-storage:1.118.0",
        "com.google.cloud:google-cloud-spanner:6.12.2",
        "com.google.cloud.functions:functions-framework-api:1.0.4",
        "commons-logging:commons-logging:1.1.1",
        "com.google.api:gax:" + GOOGLE_GAX_VERSION,
        "com.google.http-client:google-http-client-jackson2:1.40.0",
        #"com.google.crypto.tink:tink:" + TINK_VERSION, # Using Tink from github master branch until new version releases
        "com.google.cloud:google-cloud-monitoring:3.4.1",
        "com.google.api.grpc:proto-google-cloud-monitoring-v3:3.4.1",
        "com.google.protobuf:protobuf-java:" + PROTOBUF_CORE_VERSION,
        "com.google.protobuf:protobuf-java-util:" + PROTOBUF_CORE_VERSION,
        "com.google.guava:guava:30.1-jre",
        "com.google.guava:guava-testlib:30.1-jre",
        "com.google.inject:guice:4.2.3",
        "com.google.jimfs:jimfs:1.2",
        "com.google.testparameterinjector:test-parameter-injector:1.1",
        "com.google.truth.extensions:truth-java8-extension:1.1.2",
        "com.google.truth.extensions:truth-proto-extension:1.1.2",
        "com.google.truth:truth:1.1.2",
        "com.jayway.jsonpath:json-path:2.5.0",
        "io.github.resilience4j:resilience4j-core:1.7.1",
        "io.github.resilience4j:resilience4j-retry:1.7.1",
        "javax.inject:javax.inject:1",
        "io.github.resilience4j:resilience4j-core:1.7.1",
        "io.github.resilience4j:resilience4j-retry:1.7.1",
        "junit:junit:4.12",
        "org.apache.avro:avro:1.10.2",
        "org.apache.commons:commons-math3:3.6.1",
        "org.apache.httpcomponents:httpcore:4.4.14",
        "org.apache.httpcomponents:httpclient:4.5.13",
        "org.apache.httpcomponents.client5:httpclient5:5.1.3",
        "org.apache.httpcomponents.core5:httpcore5:5.1.4",
        "org.apache.httpcomponents.core5:httpcore5-h2:5.1.4",
        "org.apache.logging.log4j:log4j-1.2-api:2.17.0",
        "org.apache.logging.log4j:log4j-core:2.17.0",
        "org.awaitility:awaitility:3.0.0",
        "org.mock-server:mockserver-core:5.11.2",
        "org.mock-server:mockserver-junit-rule:5.11.2",
        "org.mock-server:mockserver-client-java:5.11.2",
        "org.hamcrest:hamcrest-library:1.3",
        "org.mockito:mockito-core:3.11.2",
        "org.slf4j:slf4j-api:1.7.30",
        "org.slf4j:slf4j-simple:1.7.30",
        "org.slf4j:slf4j-log4j12:1.7.30",
        "org.testcontainers:testcontainers:1.15.3",
        "org.testcontainers:localstack:1.15.3",
        "software.amazon.awssdk:aws-sdk-java:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:dynamodb-enhanced:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:dynamodb:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:ec2:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:regions:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:s3:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:aws-core:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:ssm:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:sts:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:sqs:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:url-connection-client:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:utils:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:auth:" + AWS_SDK_VERSION,
        "software.amazon.awssdk:lambda:" + AWS_SDK_VERSION,
    ] + TINK_MAVEN_ARTIFACTS,
    repositories = [
        "https://repo1.maven.org/maven2",
    ],
)

http_archive(
    name = "rules_java",
    sha256 = "34b41ec683e67253043ab1a3d1e8b7c61e4e8edefbcad485381328c934d072fe",
    url = "https://github.com/bazelbuild/rules_java/releases/download/4.0.0/rules_java-4.0.0.tar.gz",
)

load("@rules_java//java:repositories.bzl", "rules_java_dependencies", "rules_java_toolchains")

rules_java_dependencies()

rules_java_toolchains()

# Load specific version of differential privacy from github 2nd March 2022.

DIFFERENTIAL_PRIVACY_COMMIT = "099080e49c4c047802d785bc818898c0caf84d45"

# value recommended by the differential privacy repo.
# date, not after the specified commit to allow for more shallow clone of repo
# for faster build times.
DIFFERENTIAL_PRIVACY_SHALLOW_SINCE = "1618997113 +0200"

git_repository(
    name = "com_google_differential_privacy",
    commit = DIFFERENTIAL_PRIVACY_COMMIT,
    remote = "https://github.com/google/differential-privacy.git",
    shallow_since = DIFFERENTIAL_PRIVACY_SHALLOW_SINCE,
)

# Load dependencies for the base workspace.
load("@com_google_differential_privacy//:differential_privacy_deps.bzl", "differential_privacy_deps")

differential_privacy_deps()

###############
# Proto rules #
###############

load("@com_google_protobuf//:protobuf_deps.bzl", "protobuf_deps")

protobuf_deps()

#############
# PKG Rules #
#############

http_archive(
    name = "rules_pkg",
    sha256 = "a89e203d3cf264e564fcb96b6e06dd70bc0557356eb48400ce4b5d97c2c3720d",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_pkg/releases/download/0.5.1/rules_pkg-0.5.1.tar.gz",
        "https://github.com/bazelbuild/rules_pkg/releases/download/0.5.1/rules_pkg-0.5.1.tar.gz",
    ],
)

load("@rules_pkg//:deps.bzl", "rules_pkg_dependencies")

rules_pkg_dependencies()

############
# Go rules #
############

# Note: Go build rules are an indirect dependency of "io_bazel_rules_docker" and
# a direct dependency of rpmpack and buildifier. These rules are not used for
# deploying go code at the time of writing.

http_archive(
    name = "io_bazel_rules_go",
    sha256 = "69de5c704a05ff37862f7e0f5534d4f479418afc21806c887db544a316f3cb6b",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_go/releases/download/v0.27.0/rules_go-v0.27.0.tar.gz",
        "https://github.com/bazelbuild/rules_go/releases/download/v0.27.0/rules_go-v0.27.0.tar.gz",
    ],
)

http_archive(
    name = "bazel_gazelle",
    sha256 = "62ca106be173579c0a167deb23358fdfe71ffa1e4cfdddf5582af26520f1c66f",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/bazel-gazelle/releases/download/v0.23.0/bazel-gazelle-v0.23.0.tar.gz",
        "https://github.com/bazelbuild/bazel-gazelle/releases/download/v0.23.0/bazel-gazelle-v0.23.0.tar.gz",
    ],
)

load("@bazel_gazelle//:deps.bzl", "gazelle_dependencies")
load("@io_bazel_rules_go//go:deps.bzl", "go_register_toolchains", "go_rules_dependencies")

go_rules_dependencies()

go_register_toolchains(version = "1.17")

gazelle_dependencies()

###################
# Container rules #
###################

# Note: these rules add a dependency on the golang toolchain and must be ordered
# after any `go_register_toolchains` calls in this file (or else the toolchain
# defined in io_bazel_rules_docker are used for future go toolchains)

http_archive(
    name = "io_bazel_rules_docker",
    sha256 = "59d5b42ac315e7eadffa944e86e90c2990110a1c8075f1cd145f487e999d22b3",
    strip_prefix = "rules_docker-0.17.0",
    urls = ["https://github.com/bazelbuild/rules_docker/releases/download/v0.17.0/rules_docker-v0.17.0.tar.gz"],
)

load(
    "@io_bazel_rules_docker//repositories:repositories.bzl",
    container_repositories = "repositories",
)

container_repositories()

load("@io_bazel_rules_docker//repositories:deps.bzl", container_deps = "deps")

container_deps()

load("@io_bazel_rules_docker//container:container.bzl", "container_pull")

##############
# Containers #
##############

# Distroless image for running Java.
container_pull(
    name = "java_base",
    # Using SHA-256 for reproducibility.
    digest = "sha256:1606422cc472612cb5bcd885684b4bf87b3813246c266df473357dce5a0fb4b4",
    registry = "gcr.io",
    repository = "distroless/java",
)

# Distroless image for running C++.
container_pull(
    name = "cc_base",
    registry = "gcr.io",
    repository = "distroless/cc",
    # Using SHA-256 for reproducibility.
    # TODO: use digest instead of tag, currently it's not working.
    tag = "latest",
)

# Distroless image for running statically linked binaries.
container_pull(
    name = "static_base",
    registry = "gcr.io",
    repository = "distroless/static",
    # Using SHA-256 for reproducibility.
    # TODO: use digest instead of tag, currently it's not working.
    tag = "latest",
)

#############
# CPP Rules #
#############

http_archive(
    name = "com_google_googletest",
    strip_prefix = "googletest-e2239ee6043f73722e7aa812a459f54a28552929",
    urls = ["https://github.com/google/googletest/archive/e2239ee6043f73722e7aa812a459f54a28552929.zip"],
)

http_archive(
    name = "rules_cc",
    strip_prefix = "rules_cc-daf6ace7cfeacd6a83e9ff2ed659f416537b6c74",
    urls = ["https://github.com/bazelbuild/rules_cc/archive/daf6ace7cfeacd6a83e9ff2ed659f416537b6c74.zip"],
)

###############
# Proto rules #
###############

# rules_proto source https://github.com/bazelbuild/rules_proto
http_archive(
    name = "rules_proto",
    sha256 = "66bfdf8782796239d3875d37e7de19b1d94301e8972b3cbd2446b332429b4df1",
    strip_prefix = "rules_proto-4.0.0",
    urls = [
        "https://mirror.bazel.build/github.com/bazelbuild/rules_proto/archive/refs/tags/4.0.0.tar.gz",
        "https://github.com/bazelbuild/rules_proto/archive/refs/tags/4.0.0.tar.gz",
    ],
)

load("@rules_proto//proto:repositories.bzl", "rules_proto_dependencies", "rules_proto_toolchains")

rules_proto_dependencies()

rules_proto_toolchains()

###############################
# Binary Runtime Dependencies #
###############################

# TODO: find a better way to host kmstool binaries, using a public S3 bucket for the time being.
http_file(
    name = "kmstool_enclave_cli",
    downloaded_file_path = "kmstool_enclave_cli",
    executable = True,
    sha256 = "37dcd658328c5b57c0a6d8ea141156407de4e4fb5ac43f5906b171b2018352fc",
    urls = ["https://mgol-enclavepoc-deps.s3.us-east-2.amazonaws.com/kmstool_enclave_cli"],
)

# TODO: find a better way to host kmstool binaries, using a public S3 bucket for the time being.
http_file(
    name = "kmstool_enclave",
    downloaded_file_path = "kmstool_enclave",
    executable = True,
    urls = ["https://mgol-enclavepoc-deps.s3.us-east-2.amazonaws.com/kmstool_enclave"],
)

# TODO: find a better way to host kmstool binaries, using a public S3 bucket for the time being.
http_file(
    name = "libnsm",
    downloaded_file_path = "libnsm.so",
    executable = False,
    urls = ["https://mgol-enclavepoc-deps.s3.us-east-2.amazonaws.com/libnsm.so"],
)

###########################
# Binary Dev Dependencies #
###########################

http_archive(
    name = "terraform",
    build_file_content = """
package(default_visibility = ["//visibility:public"])
exports_files(["terraform"])
""",
    sha256 = "728b6fbcb288ad1b7b6590585410a98d3b7e05efe4601ef776c37e15e9a83a96",
    url = "https://releases.hashicorp.com/terraform/1.2.3/terraform_1.2.3_linux_amd64.zip",
)

http_archive(
    name = "packer",
    build_file_content = """
package(default_visibility = ["//visibility:public"])
exports_files(["packer"])
""",
    sha256 = "8a94b84542d21b8785847f4cccc8a6da4c7be5e16d4b1a2d0a5f7ec5532faec0",
    url = "https://releases.hashicorp.com/packer/1.7.8/packer_1.7.8_linux_amd64.zip",
)

# google cloud sdk for releasing artifacts to gcs
http_archive(
    name = "google-cloud-sdk",
    build_file_content = """
package(default_visibility = ["//visibility:public"])
exports_files(["google-cloud-sdk"])
""",
    # latest from https://cloud.google.com/storage/docs/gsutil_install#linux as of 2021-12-16
    sha256 = "94328b9c6559a1b7ec2eeaab9ef0e4702215e16e8327c5b99718750526ae1efe",
    url = "https://dl.google.com/dl/cloudsdk/channels/rapid/downloads/google-cloud-sdk-367.0.0-linux-x86_64.tar.gz",
)

# google-java-format for presubmit checks of format and unused imports
http_file(
    name = "google_java_format",
    downloaded_file_path = "google-java-format.jar",
    sha256 = "9d404cf6fe5f6aa7672693a3301ef2a22016ba540eca5d835be43104b71eb5d6",
    urls = ["https://github.com/google/google-java-format/releases/download/v1.10.0/google-java-format-1.10.0-all-deps.jar"],
)

# Needed for build containers which must execute bazel commands (e.g. //cc/aws/proxy).
http_file(
    name = "bazelisk",
    downloaded_file_path = "bazelisk",
    executable = True,
    sha256 = "84e946ed8537eaaa4d540df338a593e373e70c5ddca9f2f49e1aaf3a04bdd6ca",
    urls = ["https://github.com/bazelbuild/bazelisk/releases/download/v1.14.0/bazelisk-linux-amd64"],
)

git_repository(
    name = "com_github_google_rpmpack",
    # Lastest commit in main branch as of 2021-11-29
    commit = "d0ed9b1b61b95992d3c4e83df3e997f3538a7b6c",
    remote = "https://github.com/google/rpmpack.git",
    shallow_since = "1637822718 +0200",
)

load("@com_github_google_rpmpack//:deps.bzl", "rpmpack_dependencies")

rpmpack_dependencies()

# Note: requires golang toolchain.
http_archive(
    name = "com_github_bazelbuild_buildtools",
    sha256 = "ae34c344514e08c23e90da0e2d6cb700fcd28e80c02e23e4d5715dddcb42f7b3",
    strip_prefix = "buildtools-4.2.2",
    urls = [
        "https://github.com/bazelbuild/buildtools/archive/refs/tags/4.2.2.tar.gz",
    ],
)

################################################################################
# Download Containers: Begin
################################################################################

# Needed for reproducibly building AL2 binaries (e.g. //cc/aws/proxy)
container_pull(
    name = "amazonlinux_2",
    # Latest as of 2022-09-14.
    digest = "sha256:ba4ab64a757797930ebb0cf40a41da433cb0531877a3a2376f5427e3fdf93694",
    registry = "index.docker.io",
    repository = "amazonlinux",
    tag = "2.0.20220805.0",
)

################################################################################
# Download Containers: End
################################################################################
