def getAllProcess() {
    cmd = 'ps aux'
    def proc = cmd.execute()
    def out = proc.in.text
    return out.split('\n').toList()
}

List.metaClass.grepAll = { return delegate.grep(~/.*$it.*/)}
String.metaClass.getPid = { return delegate.split("\\s+")[1]}

println getAllProcess().grepAll('solr')[0].getPid()

println 'end'
