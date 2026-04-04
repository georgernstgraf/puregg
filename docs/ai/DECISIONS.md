# Decisions

Architectural and technical decisions made in this project.
Each entry documents WHAT was decided and WHY.

## 2026-04-04: Project Reconstruction
- **Choice**: Reconstructed the Android project from a decompiled APK instead of attempting a full rewrite.
- **Reason**: To quickly regain buildability and focus on improvement/debugging.
- **Considered**: Rewriting the app from scratch, reverse engineering and using an existing build.
- **Tradeoff**: Significant manual effort to fix decompiler errors and resolve resource conflicts.

## 2026-04-04: Build Environment
- **Choice**: Used Gradle 7.5 and Java 11 for the legacy Android project.
- **Reason**: Necessary to support the project's requirements while maintaining compatibility.
- **Considered**: Using the system-default Gradle or newer versions.
- **Tradeoff**: Requires specific environment configuration to avoid compatibility issues.
