# Project State

Current status as of 2026-05-02.

## Current Focus
#83 and #84 completed. All instrumented tests automated. Retranslate tooling implemented.

## Completed (this session)
- [x] #84 MeditationService IdlingResource — 2 meditation tests un-@Ignored, passing on API 29 + API 36 CI
  - UI Automator for meditation phase interactions (bypasses Espresso looper-idle check)
  - Data guard for CI fresh DB, forceStopMeditationForTest() cleanup
  - Fixes for dialog button targeting with className(Button) selector
- [x] #83 About page rewrite + retranslate tooling
  - Rewrote about1/2/3 with clickable HTML links
  - Implemented scripts/retranslate.py (--diff, --all, --dry-run)
  - Created scripts/locales.json (127 locales) and scripts/keep_english.json
  - Fixed 31 locales missing keep-english strings from old translate_batch9.py
  - Propagated about string updates to all 127 locales

## Completed (previous sessions)
- [x] #38 Full UI test plan automation (22 tests, 10 classes)
- [x] #80 Fixed 0-tests issue on API 36 CI
- [x] #67 Epic: Translate App into 127 OOBE languages

## Pending
- [ ] #82 Refactor namespace to `zazentimer.graf.priv.at`
- [ ] #81 Session image visibility + grip handles
- [ ] #64 Play Store
- [ ] SettingsTest.testRestore/testBackup CI failures (PreferenceFragmentCompat scroll issue)

## Known Issues
- Gradle UTP runner fails to discover tests on API 35+ emulators. Workaround: direct `am instrument`.
- SettingsTest.testRestore and testBackup fail on CI (API 29 and 36) — PreferenceFragmentCompat scroll not working in headless emulator
- SectionEditTest.testBellSoundPlayback and SessionCrudTest.testOpenEditSession fail on API 36 CI only

## Blockers
- None

## Next Session Suggestion
Consider #82 (namespace refactor), #81 (session card UI), or fixing the remaining CI test failures.
