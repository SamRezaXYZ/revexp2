package li.auna.patches.telegram.typingindicator

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.Opcode

internal val needSendTypingFingerprint = fingerprint {
    returns("V")
    custom { methodDef, _ ->
        methodDef.name == "needSendTyping"
    }
    opcodes(
        Opcode.IGET_OBJECT,
        Opcode.INVOKE_STATIC
    )
}