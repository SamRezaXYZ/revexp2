package li.auna.patches.shared.misc.settings.preference

import li.auna.util.resource.BaseResource
import org.w3c.dom.Document

/**
 * A switch preference.
 *
 * @param key The preference key. If null, other parameters must be specified.
 * @param titleKey The preference title key.
 * @param tag The preference tag.
 * @param summaryOnKey The preference summary-on key.
 * @param summaryOffKey The preference summary-off key.
 */
@Suppress("MemberVisibilityCanBePrivate")
class SwitchPreference(
    key: String? = null,
    titleKey: String = "${key}_title",
    tag: String = "SwitchPreference",
    val summaryOnKey: String = "${key}_summary_on",
    val summaryOffKey: String = "${key}_summary_off"
) : BasePreference(key, titleKey, null, tag) {
    override fun serialize(ownerDocument: Document, resourceCallback: (BaseResource) -> Unit) =
        super.serialize(ownerDocument, resourceCallback).apply {
            addSummary(summaryOnKey, SummaryType.ON)
            addSummary(summaryOffKey, SummaryType.OFF)
        }
}
