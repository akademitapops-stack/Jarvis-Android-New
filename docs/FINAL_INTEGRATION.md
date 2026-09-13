# JARVIS v2.9 — Master UI Integration

Basis: existing JARVIS v2.9 repository (not a new project).

## Pass 2 (current) — full design-token rollout + navigation fix
- Rebuilt `colors.xml` / `themes.xml` to mirror the exact CSS custom properties from `docs/design/jarvis-ui-master.html` (`--bg`, `--panel`, `--line`, `--blue`, `--cyan`, `--green`, `--amber`, `--red`, etc). Legacy color names (`primary`, `accent`, `bg_dark`, `surface`, `text_dim`…) were kept as aliases pointing at the new hex values so every existing layout cascades automatically without needing structural edits.
- Added a real drawable design system: `bg_card`, `bg_core_header` (radial Earth housing), `bg_hud_corner`, `bg_state_pill`, `bg_online_pill`, `bg_chip`, `bg_item`, `bg_nav_active`, `bg_topbar`, `bg_bottomnav` — plus reusable button/card/chip styles in `themes.xml`.
- `activity_main.xml` (Home) rebuilt: Digital Earth core header now shows 4 live HUD telemetry corners (MESSAGES / RESPONSES / SEARCHES / ACCESS, wired to `StatsTracker` + root-detection — real data, not the static demo numbers from the HTML mock), a Quick Actions row, suggestion chips above the composer, and a **9-item bottom nav that matches the HTML nav 1:1**: Home · Tools · Studio · Vision · Skills · Config · Persona · GitHub · Logs.
- **Fixed a real navigation gap**: `PersonaActivity`, `GitHubActivity`, `ToolsActivity` (custom tool builder) and `AppAccessActivity` existed in the codebase but were unreachable from any screen. They're now wired into the bottom nav / overflow menu (`AppAccessActivity` via a new "🔐 Akses Aplikasi" menu item).
- Chat bubbles (`ChatAdapter`), input field, and message-type drawables (`bg_msg_*`) recolored to the new bubble/border tokens.
- Secondary screens (`activity_dashboard`, `activity_camera_vision`, `activity_web_tools`, `activity_tools`, `activity_persona`, `activity_github`, `activity_image_generation`, `hud_arc`) recolored and given consistent monospace/cyan section headers.
- `SkillsActivity` rebuilt from a plain text dump into an HTML-style status grid (colored dot + item row + status badge).
- `AppAccessActivity` / `LogsActivity` recolored to the new token palette.
- Every touched XML file passed `xmllint --noout`; every touched Java file passed a brace/paren balance check. Full `gradle assembleDebug` still can't run in this environment (no Android SDK / no network), so an actual on-device build is the next verification step.

## Pass 1 (previous)
Integrated:
- Existing AI/provider fixes retained.
- Digital Earth Core retained and used as the main visual core.
- Master UI visual direction applied to the Android home screen: dark glass/HUD palette, Earth Network telemetry, bottom navigation, compact monospace HUD labels, and chat composer.
- Existing activities remain intact: Image Studio, Dashboard, Vision, Skills, Settings, Web Tools, Persona, Tools, GitHub, Logs and App Access.
- Provider settings retain automatic Base URL, API key paste/visibility, model discovery and model picker.
- AI state changes drive Digital Earth states: IDLE, SEARCHING/SCANNING, SPEAKING and ERROR.
- Original master HTML is included under docs/design as the design source/reference.

Build verification:
- XML resources parsed successfully.
- ZIP integrity verified.
- Full Gradle assembleDebug could not be executed in this environment because Gradle 8.5 distribution is not locally cached and outbound access to services.gradle.org is unavailable.

