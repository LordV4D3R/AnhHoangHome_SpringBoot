rootProject.name = "anhoanghome"

include(
    ":apps:runner-app",
    ":apps:expert-app",

    ":shared:common",
    ":shared:security",

    ":features:auth:auth-core",
    ":features:auth:auth-jpa",
    ":features:auth:auth-web",

    ":features:user:user-core",
    ":features:user:user-jpa",
    ":features:user:user-web",

    ":features:schedule:schedule-core",
    ":features:schedule:schedule-jpa",
    ":features:schedule:schedule-web"
)