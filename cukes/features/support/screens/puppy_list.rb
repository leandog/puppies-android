class PuppyList
  include Gametel

  list_item(:sparky, :text => 'Sparky')
  list_item(:ruby_sue, :text => 'Ruby Sue')
  list_item(:maggie_mae, :text => 'Maggie Mae')
  list_item(:brook, :text => 'Brook')

  def view_for(name)
    self.send "#{name.downcase.gsub(' ', '_')}_view"
  end

  def details_for(name)
    self.send "#{name.downcase.gsub(' ', '_')}"
  end
end
