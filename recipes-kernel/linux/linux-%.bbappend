require ${@bb.utils.contains('AGL_FEATURES', 'agldemo', 'linux_agldemo.inc', '', d) if bb.data.inherits_class('kernel', d) else ''}
