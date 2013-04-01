
require 'rspec-expectations'

require 'gametel'
require 'require_all'

require_rel 'screens'

World(Gametel::Navigation)

server = Brazenhead::Server.new '../app/bin/puppies_app-debug.apk'

class Driver
  include Brazenhead
end

Before do
  @driver = Driver.new
  server.start('PuppiesActivity')
end

After do
  server.stop
end

