# Project State

Current status as of 2026-05-03.

## Current Focus
#90 fixed: About page line breaks restored by replacing `\n` with `<br>` for `Html.fromHtml()`.

## Completed (this session)
- [x] #90 Fix missing line breaks on About page
  - Replaced `"\n\n"` with `"<br><br>"` in `ZazenTimerActivity.showAboutScreen()`
  - Replaced `\n\n` with `&lt;br&gt;&lt;br&gt;` in `about2` string across 137 locale files + base `strings.xml`

## Completed (previous sessions)
- [x] #85 localeConfig for Android 13+ per-app language support
- [x] #89 Rare language support (sub-issue of #85)
- [x] #84 MeditationService IdlingResource
- [x] #83 About page rewrite + retranslate tooling
- [x] #38 Full UI test plan automation
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
