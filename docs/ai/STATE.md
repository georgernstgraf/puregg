# Project State

Current status as of 2026-04-04.

## Current Focus
Project modernized to Java 17 and SDK 29; ongoing refactoring.

## Completed (this cycle)
- [x] Migrated to Java 17
- [x] Updated minSdkVersion to 29
- [x] PreferenceFragmentCompat migration for SettingsFragment

## Pending
- [ ] Improve code readability: Extract logic from ZazenTimerActivity into a ViewModel.
- [ ] Modernize UI/UX: Migrate remaining components to Material 3.
- [ ] Implement unit tests: Currently, only a basic test exists for BellCollection; need more robust tests for DbOperations.
- [ ] CI/CD pipeline setup: Enhance for automated test execution.

## Blockers
- None.

## Next Session Suggestion
Begin refactoring ZazenTimerActivity logic into a ViewModel.
