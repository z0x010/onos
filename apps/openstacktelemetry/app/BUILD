COMPILE_DEPS = CORE_DEPS + JACKSON + KRYO + REST + CLI + [
    "@kafka_clients//jar",
    "@jersey_client//jar",
    "@influxdb_java//jar",
    "@simpleclient//jar",
    "@simpleclient_common//jar",
    "@simpleclient_hotspot//jar",
    "@simpleclient_servlet//jar",
    "@jetty_servlet//jar",
    "@jetty_http//jar",
    "@jetty_server//jar",
    "@jetty_util//jar",
    "@jetty_websocket//jar",
    "@servlet_api//jar",
    "@io_grpc_grpc_java//core",
    "@io_grpc_grpc_java//protobuf-lite",
    "//core/store/serializers:onos-core-serializers",
    "//apps/openstacknode/api:onos-apps-openstacknode-api",
    "//apps/openstacknetworking/api:onos-apps-openstacknetworking-api",
    "//apps/openstacktelemetry/api:onos-apps-openstacktelemetry-api",
]

TEST_DEPS = TEST_ADAPTERS + TEST_REST + [
    "//core/api:onos-api-tests",
    "//core/common:onos-core-common-tests",
    "//web/api:onos-rest-tests",
]

osgi_jar_with_tests(
    api_description = "OpenStack Network Telemetry REST API",
    api_package = "org.onosproject.openstacktelemetry.web",
    api_title = "OpenStack Network Telemetry REST API",
    api_version = "1.0",
    karaf_command_packages = ["org.onosproject.openstacktelemetry.cli"],
    test_deps = TEST_DEPS,
    web_context = "/onos/openstacktelemetry",
    deps = COMPILE_DEPS,
)
