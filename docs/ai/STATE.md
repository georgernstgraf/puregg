# Project State

Current status as of 2026-04-29.

## Current Focus
Epic #67 completed. 128 languages (127 locales + English default) with full
translations. All stubs eliminated. Build verified green.

## Completed (this session)
- [x] #67 Epic: Translate App into 206 OOBE languages
  - 11 sub-issues (#68-#78), all completed and closed
  - 127 locale directories with full translations
  - 8 regional variants (en-AU/GB/IN, es-US, fr-CA, pt-BR/PT, zh-HK, ms-rMY)
  - Serbian Latin script variant (b+sr+Latn)
  - Dead strings removed from English and German source files
  - Translation script infrastructure: `scripts/retranslate.py` + `locales.json`
- [x] Enabled `-Xlint:deprecation` in `app/build.gradle` — surfaces all deprecation warnings during compilation
- [x] Fixed 14 deprecation warnings across 10 files (see CONVENTIONS.md for full migration cheat sheet)
- [x] Created `Medium_Phone_API_29` AVD (API 29, google_apis, x86_64)
- [x] Ran 6 instrumentation tests on API 29 — all pass
- [x] Ran 6 instrumentation tests on API 35 — all pass (via `am instrument`; Orchestrator broken on API 35)

## Completed (previous sessions)
- [x] Batch 9 OOBE translations: 12 new language files
- [x] Section list UI enhancements (drag handle, three-dot menu, delete/duplicate)
- [x] #60 Volume control and audio normalization
- [x] #57 Show session name on meditation screen and zen indicator in toolbar
- [x] #58 Fix ringer restoration and MainFragment stuck disabled after meditation ends
- [x] #55 Fix corrupted meditation state after natural finish
- [x] #56 Volume system simplification
- [x] #52 Fix Duplicate Session crash + instrumented test

## Pending
- [ ] #51 (remaining) Logcat correlation with screen navigation, full log capture per screen

## Known Issues
- Android Test Orchestrator does not work on API 35 (0 tests reported by Gradle UTP runner; use `am instrument` directly)

## Blockers
- None

## Next Session Suggestion
Continue with #51 logcat documentation. Consider investigating the API 35 Orchestrator failure if CI needs to run on API 35.
