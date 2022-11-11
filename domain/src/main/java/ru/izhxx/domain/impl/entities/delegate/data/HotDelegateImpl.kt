package ru.izhxx.domain.impl.entities.delegate.data

import ru.izhxx.domain.impl.entities.delegate.HotDelegate

data class HotDelegateImpl(
    override val id: Int,
    var hotData: List<HotDelegate>
): HotDelegate