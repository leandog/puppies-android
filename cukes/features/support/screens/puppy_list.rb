class PuppyList
  include Gametel

  list_item(:sparky, :text => 'Sparky')

  def view_for(name)
    self.send "#{name.downcase.gsub(' ', '_')}_view"
  end
end
