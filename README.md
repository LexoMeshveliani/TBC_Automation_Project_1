# TBC_Automation_Project_1

## 3. Strategy & Reasoning

### 3.1 Why Automate This? (25 pts)

This suite focuses on **high-traffic, reputation-sensitive journeys** where regressions are expensive and are most reliably detected through end-to-end UI behavior.

#### Scenario 1 - IT Academy: Course details & registration status
- **Risk / business value:** IT Academy is a key talent pipeline. If a course incorrectly shows **“Registration Closed”** (or the registration CTA/state is wrong), TBC can lose qualified candidates and harm employer brand.
- **Why UI automation:** This flow depends on **user-visible state across multiple pages** (navigation, course card → details, status/CTA rendering). API checks won’t catch broken routing, missing UI elements, or incorrect state presentation that candidates actually see.

#### Scenario 2 - Locations: Filter by city + type (Branch/ATM)
- **Risk / business value:** Location search drives physical visits. Incorrect filtering (wrong city/type results) wastes customer time and increases support friction.
- **Why UI automation:** The risk is in the **front-end filtering UX**: dropdowns, search inputs, and list updates. UI automation verifies the same controls customers use, including combined filters and post-filter result integrity.

#### Scenario 3 - Locations: Map ↔ list synchronization (interaction consistency)
- **Risk / business value:** Even when the underlying data is correct, a mismatch between the **map selection** and the **list “active” item** breaks trust (“the site shows one location on the map but highlights another in the list”).
- **Why UI automation:** Synchronization is a UI integration problem. Only UI automation can validate that selecting/highlighting a location on the map results in the correct **active card** in the list (and vice versa).

#### Scenario 4 - Currency converter: live conversion accuracy
- **Risk / business value:** Financial correctness is non-negotiable. Rounding/nominal mistakes lead to complaints and reputational damage.
- **Why UI automation:** The calculator’s correctness is expressed through the UI (selected currency, input amount, displayed output). UI automation validates the end-to-end chain users trust: **rate displayed → currency selected → amount entered → GEL result shown**.

#### Scenario 5 - Investor relations: financial reports download accessibility
- **Risk / business value:** Report access is time-sensitive and compliance/investor-facing. Broken downloads or unreachable reports during disclosure periods can create legal/reputational risk.
- **Why UI automation:** This is an interaction-heavy journey (section navigation, year selection, “More” expansion, format selection). UI automation ensures the **download is actually triggered** from the user’s perspective, not just that an endpoint exists.

---

### 3.2 Selector Strategy (25 pts)

**Principle:** prioritize *stability over convenience*. Prefer selectors that represent **meaning**, not layout.

**Locator priority (highest → lowest):**
1. `data-testid` / automation hooks (when available)
2. Semantic attributes or component-level classes (less likely to change than DOM nesting)
3. User-facing headings for scoping (stable anchors; good for section-based pages)
4. Text selectors for specific options (used carefully; can be localization-sensitive)
5. XPath for structural relationships only when CSS can’t express it cleanly

#### Key selector 1 - Locations list cards (stable list item container)
- **Selector:** `//div[contains(@class, 'tbcx-pw-atm-branches-section__list-item')]`
- **Why stable:** targets a **domain-specific list item component**, not a fragile index or deep nesting.
- **What could break:** a redesign that renames the component class or replaces the list structure.
- **Mitigation:** keep selectors scoped to a page object and avoid relying on child depth.

#### Key selector 2 - “Active” item in list (state-based validation)
- **Selector concept:** list item with an `active` CSS state
- **Why stable:** validates behavior via a **state class**, which typically remains consistent even if internal markup changes.
- **What could break:** if “active” state moves from class-based styling to aria/state attributes.
- **Mitigation:** fallback strategy: prefer state attributes (e.g., `aria-selected="true"`) if introduced.

#### Key selector 3 - City dropdown anchored by visible label (robust entry point)
- **Selector concept:** find the city selector by its visible label text and then scope to its parent container
- **Why stable:** users rely on this label; it’s less volatile than layout-specific CSS paths.
- **What could break:** label text changes (copy update) or localization changes.
- **Mitigation:** if available, switch to a dedicated attribute (`data-testid`) for the control.

#### Key selector 4 - Currency dropdown options by ISO code
- **Selector approach:** locate option by ISO code text (e.g., `USD`, `EUR`)
- **Why stable:** ISO 4217 codes are standardized and less likely to change than descriptive names.
- **What could break:** if UI removes codes and shows localized currency names only.
- **Mitigation:** keep a single mapping layer (code ↔ displayed label) if product changes.

#### Key selector 5 - Report sections scoped by headings (section-level robustness)
- **Selector approach:** locate a report container by the section heading (using whitespace-tolerant matching)
- **Why stable:** section headings are user-facing and typically stable across refactors.
- **What could break:** content rename or heading tag change (`h2` → `h3`).
- **Mitigation:** treat headings as “semi-stable”: prefer test IDs if they appear; otherwise keep heading strings centralized.

---

### 3.3 Flaky Test Awareness (25 pts)

**Chosen test:** *Currency converter live validation*

#### Why this test can be flaky
- **Asynchronous rendering:** rates tables and computed values may update after animations/Angular re-renders.
- **UI timing dependencies:** dropdown overlays, dynamic formatting, and recalculation delays can cause “read too early” failures.
- **Parallel execution risks:** if desktop and mobile runs share state, the wrong DOM path or cached values can be read.

#### How flakiness is prevented
- **Precondition waits before reading:** assertions are performed only after required UI elements are visible/ready.
- **Post-action verification:** after selecting a currency, verify the selection is applied (dropdown closed + button reflects the chosen option).
- **Parallel isolation:** device mode is isolated per thread so desktop/mobile logic does not leak across parallel tests.
- **Nominal-aware math:** currencies can have different base nominals (e.g., JPY quoted per 100). The expected value calculation accounts for this to prevent false negatives.

---

### 3.4 Mobile ≠ Desktop (25 pts)

**Scenario explained:** Locations (Branch/ATM) - filtering + map/list synchronization on mobile vs desktop

#### Mobile-specific behavior differences
- **Layout & density:** mobile often collapses filters into stacked controls and may show fewer list items at once; users rely on scrolling more heavily.
- **Interaction patterns:** taps replace hover; overlays (dropdowns, filter sheets) are more common and must be dismissed correctly before asserting results.
- **Performance/timing:** mobile emulation typically has slower rendering and more visible animations → assertions need stronger synchronization.

#### Different assertions & checks used on mobile
- Validate **filter overlay opens/closes** correctly before asserting list updates.
- Assert **result list count/text updates** after applying filters (city + type) rather than assuming instantaneous refresh.
- For map/list sync, assert that selecting a location results in the correct **active list card**, since that’s the primary confirmation users perceive on mobile.

#### UX risks that are higher on mobile
- Filters may apply but the list doesn’t refresh (or refreshes partially).
- The “active” location state may not visually update due to limited viewport or overlay layer issues.
- Users may see a highlighted map point but the list remains on a different item, causing navigation to the wrong branch/ATM.

By explicitly treating mobile as a distinct UX (different interaction model + timing), the suite avoids “desktop-only correctness” and validates the real customer experience.
