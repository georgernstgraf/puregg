## Completed
- [x] #10 UX fixes (Settings crash, flattened preferences), gRPC JWT token generation, and UI Test Plan creation.
- [x] #8 Startup crash
- [x] #6 Meditation start crash (PendingIntent mutability and FGS permissions)
- [x] Full automation of Start Meditation UI test scenario
- [x] #11 Background timer reliability (setAlarmClock + explicit Intent + removed doze warning)
- [x] #16 FAB icon fix (replace empty ic_plus.png with vector drawable)
- [x] #17 Session subtitle truncation fix on main screen
- [x] #18/#19 Backup/restore via Storage Access Framework + instrumented tests
- [x] CI: instrumented test runner with Android emulator
- [x] CI: Android SDK setup, JDK 17, debug APK artifact upload
- [x] #21 Phase 1: Onboarding docs, Gradle Wrapper migration, docs cleanup, dead code removal
- [x] #23 Phase 2: Modernize deprecated APIs (startForegroundService, Context constants, Activity Result API)
- [x] #22 Phase 3: Architecture modernization epic (all sub-issues complete)
- [x] #20 Improve app navigation and information architecture
  - [x] #31 Dynamic toolbar titles + NavigationUI setup
  - [x] #32 Replace Spinner with RecyclerView session list
  - [x] #33 BottomNavigationView for primary screens
  - [x] #34 FAB and per-session contextual actions
  - [x] #35 Back-press confirmation during meditation
  - [x] #36 Material Motion transitions
- [x] #51 Illustrated app documentation: 15 screenshots across 12 screens
- [x] #52 Fix Duplicate Session crash (SQLiteConstraintException on sessions._id) + instrumented test

## Completed (previous sessions)
- [x] #55 Fix corrupted meditation state after natural finish
- [x] #56 Volume system simplification

## In Progress (this session)
- [ ] #57 Show session name on meditation screen and meditation-in-progress indicator in toolbar
  - **Feature 1 (done)**: Session name below progress ring in dedicated `TextView` (`sessionNameText`), visible in all states (idle/running/paused). Idle state shows colored section arcs with first section name in the ring (no longer shows session name inside TimerView).
  - **Feature 2 (done)**: Zen circle `ImageView` (`zenIndicator`) in toolbar, toggled based on `MeditationService.isServiceRunning()`.
  - **Feature 3 (done)**: Sessions screen blocks all interactions during running meditation (card selection, Start button, Edit/Copy/Delete, FAB).
  - **Idle state redesign**: `MeditationViewModel.emitIdleState()` builds full `MeditationUiState(running=false)` with section arc data from `Section[]`. Never emits null. `MeditationFragment` has three-branch observer (idle/running/paused). Idle shows greyed stop button.
  - **Files modified**: `MeditationUiState.java`, `Meditation.java`, `MeditationService.java`, `MeditationViewModel.java`, `MeditationFragment.java`, `MainFragment.java`, `ZazenTimerActivity.java`, `fragment_meditation.xml` (portrait + landscape), `main.xml`
  - **Status**: Build passes (`./gradlew build` + `assembleDebugAndroidTest`). Needs device testing before closing.

## Pending
- [ ] #51 (remaining) Logcat correlation with screen navigation, full log capture per screen

## Blockers
- None

## Next Session Suggestion
Test #57 on device/emulator, then close the issue if all features work correctly.
